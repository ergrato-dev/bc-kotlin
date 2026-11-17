#!/usr/bin/env bash
# ¿Qué? Compila y prueba cada starter/ de una semana dentro del contenedor bc-kotlin-dev.
# ¿Para qué? Garantizar dos cosas de cada ejercicio y proyecto:
#   1. Tal cual se publica, compila y sus tests FALLAN (el aprendiz tiene trabajo).
#   2. Con los pasos resueltos (líneas `//> ` descomentadas y `TODO("Paso ...")` quitados),
#      los tests PASAN (los pasos del README llevan al verde).
# ¿Impacto? Un starter que no cumple las dos cosas no se publica.
# Uso: ./scripts/compilar-starters.sh week-01
set -euo pipefail

week="${1:?Uso: $0 week-NN}"
root="$(cd "$(dirname "$0")/.." && pwd)"
dir=$(find "$root/bootcamp" -maxdepth 1 -type d -name "${week}-*" | head -n1)
[[ -n "$dir" ]] || { echo "No existe bootcamp/${week}-*"; exit 1; }

image=bc-kotlin-dev
docker image inspect "$image" >/dev/null 2>&1 || docker build -q -t "$image" "$root/docker" >/dev/null

gradle() { # $1 = carpeta del proyecto; resto = argumentos de gradlew
  local project="$1"; shift
  docker run --rm -v bc-kotlin-gradle:/home/ubuntu/.gradle -v "$project":/workspace "$image" \
    ./gradlew -q --console=plain "$@" >/dev/null 2>&1
}

fail=0
while IFS= read -r starter; do
  name="${starter#"$dir"/}"
  tmp=$(mktemp -d)
  cp -r "$starter"/. "$tmp"/
  chmod -R a+rwX "$tmp"

  if ! gradle "$tmp" compileKotlin compileTestKotlin; then
    echo "❌ $name: no compila tal cual"; fail=1; rm -rf "$tmp"; continue
  fi
  # Los tests deben fallar en el starter. Un starter sin pasos (solo lectura) lleva NO_STEPS.
  if [[ ! -f "$starter/NO_STEPS" ]] && gradle "$tmp" test; then
    echo "❌ $name: los tests ya pasan sin resolver nada"; fail=1
  fi

  if [[ "$name" == 3-proyecto/* ]]; then
    # El proyecto no trae la solución: se prueba con la del instructor si está clonada al lado.
    solution="$root/../bc-instructor/bc-kotlin/$(basename "$dir")/3-proyecto"
    if [[ ! -d "$solution/src" ]]; then
      echo "⚠️  $name: compila y falla; sin solución del instructor en $solution"; rm -rf "$tmp"; continue
    fi
    cp -r "$solution/src"/. "$tmp/src"/
  else
    find "$tmp/src" -name '*.kt' -print0 | xargs -0 sed -i -E '/TODO\("Paso [0-9]+"\)/d; s#^([[:space:]]*)//> ?#\1#'
  fi
  if gradle "$tmp" test; then
    echo "✅ $name"
  else
    echo "❌ $name: con los pasos resueltos los tests no pasan"; fail=1
  fi
  rm -rf "$tmp"
done < <(find "$dir" -type d -name starter -not -path '*/build/*' | sort)

exit "$fail"

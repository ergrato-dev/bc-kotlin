# Contribuir a bc-kotlin

Gracias por querer mejorar el bootcamp. Antes de escribir nada, lee
[`.github/copilot-instructions.md`](.github/copilot-instructions.md): es la fuente de
verdad de estructura, estilo y formato.

## Qué se considera un fallo

- **Código que no compila** o que produce un warning con la toolchain fijada en
  [`docs/stack-versions.md`](docs/stack-versions.md).
- **Una salida o un mensaje de error citado que no coincide** con lo que imprime el
  compilador o el programa de verdad.
- **Un paso que da algo por sabido**: un término sin definir, un comando sin explicar,
  un resultado esperado que no se muestra.
- **Un concepto usado antes de su semana.**
- Voseo, `npm`, `pip` o MySQL en el contenido.

## Cómo comprobar tu cambio

```bash
docker build -t bc-kotlin-dev docker
./scripts/compilar-starters.sh week-NN
./scripts/verificar-enlaces.sh
```

Un fragmento suelto de teoría se comprueba dentro del contenedor:

```bash
kotlinc fragmento.kt -include-runtime -d fragmento.jar && java -jar fragmento.jar
```

## Commits

Conventional Commits en inglés, con la semana como ámbito:

```
fix(week-03): correct the expected output of the when exercise
feat(week-06): add lambdas and higher-order functions week
```

## Checklist del pull request

- [ ] `./scripts/compilar-starters.sh` en verde en las semanas tocadas
- [ ] `./scripts/verificar-enlaces.sh` en verde
- [ ] Toda salida citada se copió de una ejecución real
- [ ] Ninguna carpeta `solution/`

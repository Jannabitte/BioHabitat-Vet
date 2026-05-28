# BioHabitat Vet

## Descripción del proyecto

BioHabitat Vet es una aplicación desarrollada en Java que integra conocimientos de medicina veterinaria, bienestar animal y evaluación ambiental. El proyecto fue creado con el objetivo de apoyar el registro, análisis y generación de reportes relacionados con pacientes animales, considerando tanto especies domésticas como especies silvestres.

La idea principal nace desde una mirada veterinaria práctica: un profesional puede atender en un mismo día a un perro, un gato o un conejo doméstico, pero también puede enfrentarse a especies silvestres como un zorro culpeo, una iguana, una tortuga terrestre u otros animales que requieran evaluación clínica, ambiental o de manejo. Por esta razón, la aplicación fue pensada para funcionar en ambos contextos.

El sistema permite ingresar datos del paciente, seleccionar la especie, registrar condiciones ambientales, dieta, comportamiento, medicación y observaciones clínicas. Luego, la aplicación analiza la información ingresada y genera una evaluación con parámetros ideales, advertencias, riesgos frecuentes, recomendaciones de dieta y seguimiento, compatibilidad ambiental y nivel de riesgo general.
## Capturas de demostración

### Interfaz principal

![Interfaz principal de BioHabitat Vet](assets/Bio_Habitat.png)

### Evaluación de especie silvestre

![Evaluación de zorro culpeo en BioHabitat Vet](assets/BioHabitat2.png)

### Reporte HTML generado

![Reporte HTML generado por BioHabitat Vet](assets/HTMLZorroCulpeo.png)


## Objetivo del proyecto

El objetivo de este proyecto fue crear una herramienta funcional que relacionara la programación en Java con un contexto real de medicina veterinaria y fauna silvestre.

Con esta aplicación busqué demostrar que los conocimientos de programación pueden aplicarse a problemas concretos, especialmente en áreas donde el registro de información, la evaluación de condiciones y la generación de reportes pueden ser importantes para tomar mejores decisiones.

También quise desarrollar una solución que no estuviera limitada solo a mascotas o animales domésticos, sino que pudiera adaptarse a distintas especies y situaciones, incluyendo pacientes silvestres, animales en rescate, rehabilitación, cautiverio temporal o evaluación ambiental.

## Problema que busca solucionar

En medicina veterinaria, el paciente no siempre pertenece al mismo grupo o ambiente. Un animal doméstico suele tener parámetros y necesidades diferentes a una especie silvestre. Sin embargo, ambos pueden requerir evaluación clínica, registro de datos, análisis del entorno y seguimiento.

Este proyecto busca ordenar esa información en una herramienta sencilla, permitiendo al usuario ingresar datos relevantes y recibir una evaluación básica que ayude a identificar si las condiciones actuales son compatibles o no con las necesidades de la especie.

Por ejemplo, si se evalúa un perro en un ambiente doméstico, el sistema puede analizar temperatura, humedad, iluminación, dieta y observaciones clínicas desde una perspectiva de bienestar animal. Pero si se evalúa un zorro culpeo, el sistema también puede considerar su hábitat natural, su categoría funcional, riesgos asociados al manejo y compatibilidad con el entorno ingresado.

## Público objetivo

Este proyecto puede ser útil para distintos tipos de usuarios:

* Estudiantes de medicina veterinaria.
* Estudiantes de programación interesados en soluciones aplicadas.
* Médicos veterinarios que necesiten registrar información básica de pacientes.
* Personas que trabajen en rescate, rehabilitación o manejo de fauna.
* Centros educativos que quieran mostrar el vínculo entre tecnología, salud animal y ambiente.
* Profesionales o estudiantes interesados en el enfoque One Health.
* Personas que deseen comprender cómo la programación puede apoyar procesos de análisis veterinario y ambiental.

Aunque es una aplicación de práctica, su enfoque permite imaginar futuras versiones más completas para clínicas, centros de rescate, hospitales veterinarios, zoológicos, criaderos responsables, centros de rehabilitación de fauna o proyectos educativos.

## Funcionalidades principales

* Registro del nombre del paciente.
* Selección de especie.
* Búsqueda o ingreso de nombre científico.
* Registro de temperatura actual.
* Selección de humedad actual.
* Selección de iluminación actual.
* Selección del ambiente actual.
* Registro de dieta alimentaria.
* Registro de comportamiento observado.
* Registro de observaciones clínicas.
* Registro de medicamento actual.
* Registro de medicamento anterior.
* Registro de próximo medicamento.
* Registro de fecha próxima de medicación.
* Evaluación clínica y ambiental del paciente.
* Identificación del grupo biológico.
* Identificación de categoría funcional.
* Identificación del hábitat natural.
* Visualización de parámetros ideales.
* Advertencias médicas críticas.
* Riesgos frecuentes según especie.
* Recomendaciones de dieta y seguimiento.
* Evaluación de compatibilidad ambiental.
* Resultado general con nivel de riesgo.
* Generación de historial de paciente.
* Generación de reporte HTML.
* Apertura del reporte en el navegador.

## Especies consideradas

El sistema fue pensado para trabajar con distintas especies, tanto domésticas como silvestres. Entre los ejemplos utilizados se encuentran:

* Perro.
* Conejo.
* Iguana.
* Tortuga terrestre.
* Zorro culpeo.

Esto permite que la aplicación sea más flexible y no quede limitada a un solo tipo de paciente. La diferencia entre especies es importante porque cada una puede tener necesidades ambientales, alimentarias y clínicas distintas.

## Enfoque veterinario y ambiental

BioHabitat Vet no solo registra datos básicos del paciente, sino que también considera el ambiente donde se encuentra el animal. Esto es relevante porque el bienestar animal no depende únicamente de la atención médica, sino también de las condiciones del entorno.

La aplicación evalúa factores como:

* Temperatura.
* Humedad.
* Iluminación.
* Ambiente actual.
* Dieta.
* Comportamiento.
* Observaciones clínicas.
* Medicación.
* Riesgos asociados a la especie.

Este enfoque permite relacionar la salud del animal con el ambiente en el que se encuentra, lo que es especialmente importante en especies silvestres o animales en situación de rescate.

## Ejemplo de uso con especie doméstica

Un ejemplo de uso es el registro de una paciente canina llamada Valkiria. En este caso, el sistema permite ingresar datos como especie, nombre científico, temperatura, humedad, iluminación, ambiente, dieta, comportamiento, observaciones clínicas y medicación.

Luego, la aplicación genera una evaluación indicando si las condiciones ingresadas son compatibles o no con los parámetros ideales para la especie. También entrega una conclusión general y un nivel de riesgo, como moderado o alto, dependiendo de la información ingresada.

Este tipo de uso puede representar una atención veterinaria básica, un seguimiento clínico o una evaluación de bienestar.

## Ejemplo de uso con especie silvestre

Otro ejemplo es el registro de un zorro culpeo. En este caso, la aplicación reconoce que se trata de una especie silvestre y entrega información relacionada con su grupo, categoría funcional, hábitat natural y riesgos frecuentes.

El sistema puede advertir sobre aspectos importantes como estrés, deshidratación, agitación o dificultad de adaptación al ambiente ingresado. También puede indicar si la temperatura, humedad, iluminación o ambiente actual son compatibles con las necesidades de la especie.

Este enfoque permite representar una situación más cercana a rescate, rehabilitación o evaluación ambiental de fauna silvestre.

## Generación de reportes

Una de las funciones importantes del proyecto es la generación de un reporte HTML. Al presionar el botón correspondiente, el sistema abre un reporte en el navegador, donde se visualiza la información registrada y la evaluación generada.

Este reporte permite presentar la información de forma más ordenada y legible, separando los datos principales del paciente, los parámetros ideales, las advertencias, riesgos y conclusiones.

Para proteger la privacidad y evitar subir información sensible al repositorio público, los archivos `.txt` y el archivo `reporte.html` fueron excluidos mediante `.gitignore`, ya que pueden contener datos de pacientes, observaciones clínicas o registros generados por la aplicación.

## Uso de archivos generados

Durante la ejecución del programa se pueden generar archivos de texto e informes HTML. Estos archivos sirven para registrar historiales o reportes, pero no forman parte del código fuente principal del proyecto.

Por seguridad y buenas prácticas, decidí no subir estos archivos al repositorio público. Esta decisión permite mantener el proyecto más limpio y proteger posibles datos ingresados durante las pruebas.

## Tecnologías utilizadas

* Java.
* Java Swing.
* IntelliJ IDEA.
* Git.
* GitHub.
* Generación de archivos.
* Reportes HTML.
* Manejo de eventos.
* Programación orientada a objetos.
* Estructuras condicionales.
* Manejo de datos ingresados por el usuario.

## Conceptos aplicados

Durante el desarrollo de este proyecto apliqué distintos conceptos importantes de programación:

* Creación de una aplicación de escritorio.
* Diseño de interfaz gráfica.
* Uso de formularios.
* Manejo de botones y eventos.
* Validación y lectura de datos.
* Organización de información por especie.
* Evaluación mediante condiciones.
* Generación de texto de análisis.
* Escritura de archivos.
* Creación de reportes HTML.
* Apertura de archivos en navegador.
* Uso de `.gitignore` para proteger archivos generados y privados.
* Control de versiones con Git y GitHub.
* Uso de ramas y Pull Requests para mejorar el repositorio.

## Organización del proyecto

El proyecto se organizó en un repositorio independiente llamado:

```text
BioHabitat-Vet
```

Dentro del repositorio se subió principalmente el código fuente de la aplicación, junto con el archivo `.gitignore` y la documentación del proyecto.

No se subieron los archivos `.txt` ni el archivo `reporte.html`, ya que estos son generados por la aplicación y pueden contener datos ingresados durante las pruebas.

## Buenas prácticas aplicadas en GitHub

Para mantener el repositorio más profesional, se trabajó con buenas prácticas como:

* Creación de un repositorio independiente.
* Uso de `.gitignore`.
* Exclusión de archivos generados por la aplicación.
* Exclusión de archivos con posible información sensible.
* Limpieza de archivos privados de IntelliJ.
* Uso de una rama separada para realizar mejoras.
* Creación y fusión de un Pull Request.
* Documentación del proyecto mediante README.

Esto permite que el repositorio sea más ordenado, seguro y fácil de revisar.

## Escalabilidad del proyecto

Este proyecto fue pensado como una base que puede seguir creciendo. Actualmente permite evaluar distintas especies y generar reportes, pero en el futuro podría ampliarse con nuevas funcionalidades.

Algunas mejoras posibles serían:

* Agregar más especies domésticas y silvestres.
* Crear una base de datos con parámetros por especie.
* Guardar historiales clínicos de forma más estructurada.
* Agregar búsqueda por nombre común o científico.
* Incorporar niveles de riesgo más detallados.
* Mejorar la interfaz visual.
* Exportar reportes en PDF.
* Agregar gráficos o indicadores visuales.
* Incorporar recomendaciones según edad, estado clínico o contexto.
* Separar el código en más clases para mejorar la organización.
* Integrar una base de datos real.
* Crear una versión web en el futuro.

## Relación con medicina veterinaria

Este proyecto tiene una relación directa con el área veterinaria, porque considera aspectos clínicos, ambientales y de bienestar animal.

La aplicación no reemplaza el criterio profesional de un médico veterinario, pero sí permite representar cómo una herramienta tecnológica puede apoyar el registro y análisis de información. También ayuda a visualizar cómo distintos factores del entorno pueden influir en el bienestar de un paciente animal.

Además, el proyecto reconoce que la medicina veterinaria no se limita solo a perros y gatos. También puede involucrar fauna silvestre, animales exóticos, especies en rescate o pacientes que requieren evaluación ambiental.

## Reflexión personal

Este proyecto fue muy importante para mí porque pude unir mis intereses por la medicina veterinaria, la fauna silvestre, el bienestar animal y la programación.

Quise desarrollar una aplicación que no fuera solo un ejercicio técnico, sino que tuviera una idea aplicada a una situación real. En la práctica veterinaria, un profesional puede atender animales domésticos y también especies silvestres, por lo que me pareció importante crear un sistema que pudiera funcionar en ambos casos.

También aprendí la importancia de cuidar los datos que se suben a GitHub. En este proyecto decidí no subir archivos `.txt` ni reportes generados, porque pueden contener nombres, observaciones o información sensible. Esto me ayudó a comprender mejor la importancia de la seguridad, la privacidad y el orden dentro de un repositorio público.

Además, pude practicar el uso de GitHub de una forma más profesional, creando un repositorio independiente, limpiando archivos privados y utilizando Pull Request para fusionar mejoras.

## Estado del proyecto

El proyecto se encuentra funcional como una aplicación de escritorio en Java. Permite registrar información de pacientes animales, evaluar condiciones clínicas y ambientales, generar un análisis general y abrir un reporte HTML en el navegador.

Actualmente funciona como una versión inicial o prototipo educativo, con posibilidades de seguir creciendo y mejorando en futuras versiones.

## Nota importante

Creado por Jannabitte Pino,
Estudiante Medicina Veterinaria y La información entregada por esta aplicación es de carácter educativo y demostrativo. No reemplaza la evaluación, diagnóstico ni tratamiento realizado por un médico veterinario. 
Su objetivo es representar cómo una herramienta informática puede apoyar el registro y análisis básico de datos clínicos y ambientales.



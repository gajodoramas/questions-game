package Clases

import aplicaciondepreguntas.main.MenuPrincipal
import java.io.File
import java.io.IOException
import java.io.RandomAccessFile

data class Pregunta(val pregunta : String, val respuesta : Boolean, val explicacion : String) {

    companion object {

        val listaPreguntas = ArrayList<Pregunta>()
        private var rutaArchivo = File(MenuPrincipal.applicationContext().filesDir, "Preguntas.dat")

        /**
         * Lee el archivo de preguntas y las carga en el arrayList.
         */
        fun leerArchivoPreguntas() {

            try {

                val archivo = RandomAccessFile(rutaArchivo, "r")

                var pregunta = CharArray(77)
                var respuesta: Boolean;
                var explicacion = CharArray(50)

                archivo.seek(0)

                while (archivo.filePointer < archivo.length()) {

                    for (i in 0..76) {
                        pregunta[i] = archivo.readChar()
                    }

                    respuesta = archivo.readBoolean()

                    for (i in 0..49) {
                        explicacion[i] = archivo.readChar()
                    }

                    listaPreguntas.add(Pregunta(String(pregunta), respuesta, String(explicacion)))

                }
            } catch (e: Exception) {
                println(e.message)
            }
        }

        /**
         * Guarda las preguntas del arrayList en el archivo.
         */
        fun escribirArchivoPreguntas() {

            try {

                val archivo = RandomAccessFile(rutaArchivo, "rw")
                var buffer: StringBuffer?

                archivo.seek(0)

                for (Pregunta in listaPreguntas) {

                    buffer = StringBuffer(Pregunta.pregunta)
                    buffer.setLength(77) // Esta lognitud se debe a que el EditText está capado a 75 caracteres, a los que luego añado las dos interrogaciones
                    archivo.writeChars(buffer.toString())

                    archivo.writeBoolean(Pregunta.respuesta)

                    buffer = StringBuffer(Pregunta.explicacion)
                    buffer.setLength(50) // El EditText está capado a un máximo de 50 caracteres
                    archivo.writeChars(buffer.toString())
                }

                archivo.close()

            } catch (ex: IOException) {
                println(ex.message)
            }
        }

        /**
         * Comprueba la existencia del archivo de preguntas y, en caso de su inexistencia, lo crea
         * con 5 preguntas, que también añade al arrayList.
         */
        fun comprobarArchivoPreguntas() {

            if (!rutaArchivo.exists()) {

                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'Jurassic Park' se estrenó en el año 1993?",
                        true,
                        "Se estrenó el 9 de Junio de 1993"
                    )
                )
                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'La Comunidad del Anillo' se estrenó en el año 2002?",
                        false,
                        "Se estrenó el 19 de Diciembre de 2001"
                    )
                )
                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'Harry Potter y la Piedra Filosofal' se estrenó en el año 2001?",
                        true,
                        "Se estrenó el 4 de Noviembre de 2001"
                    )
                )
                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'Titanic' se estrenó en el año 1998?",
                        false,
                        "Se estrenó el 19 de Diciembre de 1997"
                    )
                )
                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'El Rey León' se estrenó en el año 1995?",
                        false,
                        "Se estrenó el 24 de Junio de 1994"
                    )
                )
                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'Avatar' se estrenó en el año 2009?",
                        true,
                        "Se estrenó el 18 de Diciembre de 2009"
                    )
                )
                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'Vengadores: Endgame' se estrenó en el año 2018?",
                        false,
                        "Se estrenó el 25 de Abril de 2019"
                    )
                )
                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'Toy Story' se estrenó en el año 1995?",
                        true,
                        "Se estrenó el 22 de Noviembre de 1995"
                    )
                )

                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'Frozen' se estrenó en el año 2013?",
                        true,
                        "Se estrenó el 27 de Noviembre de 2013"
                    )
                )

                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'Spider-Man' de 2002 se estrenó en el año 2001?",
                        false,
                        "Se estrenó el 3 de Mayo de 2002"
                    )
                )

                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'Regreso al Futuro' se estrenó en el año 1985?",
                        true,
                        "Se estrenó el 3 de Julio de 1985"
                    )
                )

                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'El Señor de los Anillos: El Retorno del Rey' se estrenó en el año 2003?",
                        true,
                        "Se estrenó el 17 de Diciembre de 2003"
                    )
                )

                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'Piratas del Caribe: La Maldición de la Perla Negra' se estrenó en el año 2004?",
                        false,
                        "Se estrenó el 9 de Julio de 2003"
                    )
                )

                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'Matrix' se estrenó en el año 1999?",
                        true,
                        "Se estrenó el 31 de Marzo de 1999"
                    )
                )

                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'Shrek' se estrenó en el año 2001?",
                        true,
                        "Se estrenó el 22 de Abril de 2001"
                    )
                )

                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'Los Increíbles' se estrenó en el año 2005?",
                        false,
                        "Se estrenó el 5 de Noviembre de 2004"
                    )
                )

                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'Iron Man' se estrenó en el año 2008?",
                        true,
                        "Se estrenó el 2 de Mayo de 2008"
                    )
                )

                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'Interstellar' se estrenó en el año 2014?",
                        true,
                        "Se estrenó el 7 de Noviembre de 2014"
                    )
                )

                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'El Hobbit: Un viaje inesperado' se estrenó en el año 2011?",
                        false,
                        "Se estrenó el 14 de Diciembre de 2012"
                    )
                )

                listaPreguntas.add(
                    Pregunta(
                        "¿La película 'Buscando a Nemo' se estrenó en el año 2003?",
                        true,
                        "Se estrenó el 30 de Mayo de 2003"
                    )
                )

                escribirArchivoPreguntas()

            } else {
                leerArchivoPreguntas()
            }
        }

        /**
         * Guarda una sola pregunta en el archivo. Pensado para usar desde la actividad de añadir
         * preguntas.
         */
        fun guardarNuevaPregunta(nuevaPregunta : Pregunta) {

            try {

                val file = RandomAccessFile(rutaArchivo, "rw")

                var buffer: StringBuffer?

                file.seek(file.length())

                buffer = StringBuffer(nuevaPregunta.pregunta)
                buffer.setLength(77) // Esta lognitud se debe a que el EditText está capado a 75 caracteres, a los que luego añado las dos interrogaciones
                file.writeChars(buffer.toString())

                file.writeBoolean(nuevaPregunta.respuesta)

                buffer = StringBuffer(nuevaPregunta.explicacion)
                buffer.setLength(50) // El EditText está capado a un máximo de 50 caracteres
                file.writeChars(buffer.toString())

                file.close()

            } catch (ex: IOException) {
                println(ex.message)
            }
        }
    }
}
package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Задание №2
 *
 * <p>Тема: "Потоковый ввод-вывод. Чтение и запись данных
 * в текстовом режиме".
 */
public class Task2 implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException {
        File input = new File("assets/countries.txt");
        File output = new File("countries_text_mode_output.txt");
        String text = read(input);
        write(output, text);

        /*
         * TODO(Студент): Выполнить задание №2
         *
         * 1. Реализовать метод read.
         *
         *    При чтении файла следует пользоваться типами данных:
         *    Reader, FileReader.
         *
         *    Для сохранения прочитанных данных следует пользоваться
         *    классом StringBuilder.
         *
         * 2. Реализовать метод write.
         *
         *    При реализации метода следует пользоваться типами данных:
         *    Writer и FileWriter.
         *
         * 3. С использованием отладчика проверить корректность работы программы.
         */
    }

    /**
     * Выполняет чтение указанного файла в текстовом режиме.
     *
     * <p>Весь текст файла возвращается в виде одного
     * экземпляра типа {@link String}.
     *
     * @param file файл
     * @return содержимое файла в виде текста.
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private String read(File file) throws IOException {
       // throw new UnsupportedOperationException("Not implement yet!");
        try (InputStream input = new FileInputStream(file);                     // autoclosable 
                Reader reader = new InputStreamReader(input)) {
            String text = "";
            char[] buffer = new char[16];
            int len;
            while((len = reader.read(buffer)) != -1) {                          // пока кол-во прочитанных байтов не равно -1
                text += new String(buffer);                                     // добавляем символы в строку
            }
            return text;
        }
    }

    /**
     * Выполняет запись текстоых данных в файл в текстовом
     * режиме.
     *
     * @param file файл
     * @param text текст
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private void write(File file, String text) {
        try {Writer writer = new FileWriter(file);
            // throw new UnsupportedOperationException("Not implemented yet!");
            writer.write(text);                                                 // записать
        } catch (IOException ex) {
            Logger.getLogger(Task2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
       
    }
}

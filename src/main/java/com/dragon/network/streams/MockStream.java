package com.dragon.network.streams;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author huangzhibo
 * @date 14/08/2017
 */
public class MockStream {


    public static void generateCharacters(OutputStream out) throws IOException{

        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters = 94;
        int numberOfCharacterPerLine = 72;

        int start = firstPrintableCharacter;
        while (true){
            for (int i = start; i < start + numberOfCharacterPerLine; i++) {
                out.write((
                        (i - firstPrintableCharacter) % numberOfPrintableCharacters)
                        + firstPrintableCharacter);
            }
            out.write('\r');
            out.write('\n');
            start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;
        }

    }

    public static void generateCharacters1(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters = 94;
        int numberOfCharactersPerLine = 72;
        int start = firstPrintableCharacter;
        byte[] line = new byte[numberOfCharactersPerLine + 2]; // the +2 is for the carriage return and linefeed
        while (true) { /* infinite loop */
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                line[i - start] = (byte) ((i - firstPrintableCharacter)
                        % numberOfPrintableCharacters + firstPrintableCharacter);
            }
            line[72] = (byte) '\r'; // carriage return line[73] = (byte) '\n'; // line feed out.write(line);
            start = ((start + 1) - firstPrintableCharacter)
                    % numberOfPrintableCharacters + firstPrintableCharacter;
        }
    }

}

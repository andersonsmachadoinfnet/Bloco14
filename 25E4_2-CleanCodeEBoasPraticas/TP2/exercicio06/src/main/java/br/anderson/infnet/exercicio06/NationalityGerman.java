package br.anderson.infnet.exercicio06;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class NationalityGerman implements NationalityColors{
    @Override
    public List getFlagColors(Nationality nationality) {
        if (nationality==Nationality.GERMAN) {
            return Arrays.asList(Color.BLACK, Color.RED, Color.YELLOW);
        }
        return List.of();
    }
}

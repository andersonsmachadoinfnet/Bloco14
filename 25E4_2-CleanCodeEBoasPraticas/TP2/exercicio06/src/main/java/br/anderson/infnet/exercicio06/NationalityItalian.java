package br.anderson.infnet.exercicio06;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class NationalityItalian implements NationalityColors{
    @Override
    public List getFlagColors(Nationality nationality) {
        if (nationality==Nationality.ITALIAN) {
            return Arrays.asList(Color.GREEN, Color.WHITE, Color.RED);
        }
        return List.of();
    }
}

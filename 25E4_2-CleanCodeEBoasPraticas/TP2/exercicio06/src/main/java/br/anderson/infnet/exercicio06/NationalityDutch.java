package br.anderson.infnet.exercicio06;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class NationalityDutch implements NationalityColors{
    @Override
    public List getFlagColors(Nationality nationality) {
        if (nationality==Nationality.DUTCH) {
            return Arrays.asList(Color.RED, Color.WHITE, Color.BLACK);
        }
        return List.of();
    }
}

package br.anderson.infnet.exercicio06;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class NationalityBelgian implements NationalityColors{
    @Override
    public List getFlagColors(Nationality nationality) {
        if (nationality==Nationality.BELGIAN) {
            return Arrays.asList(Color.BLACK, Color.YELLOW, Color.RED);
        }
        return List.of();
    }
}

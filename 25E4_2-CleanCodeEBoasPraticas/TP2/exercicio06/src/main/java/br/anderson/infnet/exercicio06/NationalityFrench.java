package br.anderson.infnet.exercicio06;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class NationalityFrench implements NationalityColors{
    @Override
    public List getFlagColors(Nationality nationality) {
        if (nationality==Nationality.FRENCH) {
            return Arrays.asList(Color.BLUE, Color.WHITE, Color.RED);
        }
        return List.of();
    }
}

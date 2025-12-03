package br.anderson.infnet.exercicio06;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class NationalityUnclassifield implements NationalityColors{
    @Override
    public List getFlagColors(Nationality nationality) {
        if (nationality==Nationality.UNCLASSIFIED) {
            return Arrays.asList(Color.GRAY);
        }
        return List.of();
    }
}

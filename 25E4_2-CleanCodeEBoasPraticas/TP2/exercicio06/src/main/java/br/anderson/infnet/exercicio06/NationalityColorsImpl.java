package br.anderson.infnet.exercicio06;

import java.util.ArrayList;
import java.util.List;

public class NationalityColorsImpl implements NationalityColors {
    private List<NationalityColors> nationalityColorsList;

    public NationalityColorsImpl() {
        nationalityColorsList = new ArrayList<NationalityColors>();
        nationalityColorsList.add(new NationalityDutch());
        nationalityColorsList.add(new NationalityGerman());
        nationalityColorsList.add(new NationalityBelgian());
        nationalityColorsList.add(new NationalityFrench());
        nationalityColorsList.add(new NationalityItalian());
        nationalityColorsList.add(new NationalityUnclassifield());
    }

    @Override
    public List getFlagColors(Nationality nationality) {
        List cor = null;
        for (NationalityColors nationalityColors : nationalityColorsList) {
            cor = nationalityColors.getFlagColors(nationality);
            if (cor.size() > 0) {
                return cor;
            }
        }

        return cor;
    }
}

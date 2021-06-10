package al.ikubinfo.commons.utils;

import al.ikubinfo.commons.exception.NotImplementedEx;

import java.math.BigDecimal;

public final class UnitConverter {
    private static double LENGTH_INCHES = 39.37;
    private static double LENGTH_FEET = 3.28;
    private static double LENGTH_MILES = 0.00062;
    private static double LENGTH_MILLIMETERS = 1000;
    private static double LENGTH_CENTIMETERS = 100;
    private static double LENGTH_METERS = 1;
    private static double LENGTH_KILOMETERS = 0.001;

    private static double MASS_KILOGRAM = 0.001;
    private static double MASS_GRAM = 1;
    private static double MASS_MILLIGRAM = 1000;
    private static double MASS_STONE = 0.000157473;
    private static double MASS_POUND = 0.00220462;
    private static double MASS_OUNCE = 0.035274;

    private static double toMeters(String unit, Double val) {
        System.out.println("-----4 -----");

        if (unit.equalsIgnoreCase("in")) {
            return (val / LENGTH_INCHES);
        } else if (unit.equalsIgnoreCase("ft")) {
            return (val / LENGTH_FEET);
        } else if (unit.equalsIgnoreCase("mi")) {
            return (val / LENGTH_MILES);
        } else if (unit.equalsIgnoreCase("mm")) {
            return (val / LENGTH_MILLIMETERS);
        } else if (unit.equalsIgnoreCase("cm")) {
            return (val / LENGTH_CENTIMETERS);
        } else if (unit.equalsIgnoreCase("m")) {
            return (val / LENGTH_METERS);
        } else if (unit.equalsIgnoreCase("km")) {
            return (val / LENGTH_KILOMETERS);
        } else {
            throw new NotImplementedEx("This unit is not implemented , " + unit);
        }
    }

    private static double toGrams(String unit, Double val) {
        System.out.println("-----3 -----");

        if (unit.equalsIgnoreCase("g") || unit.equalsIgnoreCase("gm")) {
            return (val / MASS_GRAM);
        } else if (unit.equalsIgnoreCase("mg")) {
            return (val / MASS_MILLIGRAM);
        } else if (unit.equalsIgnoreCase("oz")) {
            return (val / MASS_OUNCE);
        } else if (unit.equalsIgnoreCase("kg")) {
            return (val / MASS_KILOGRAM);
        } else if (unit.equalsIgnoreCase("lb")) {
            return (val / MASS_POUND);
        } else if (unit.equalsIgnoreCase("st")) {
            return (val / MASS_STONE);
        } else {
            throw new NotImplementedEx("This unit is not implemented , " + unit);
        }
    }

    private static double fromMeters(String unit, Double meters) {
        System.out.println("-----2 -----");

        if (unit.equalsIgnoreCase("in")) {
            return LENGTH_INCHES * 100 * meters;
        } else if (unit.equalsIgnoreCase("ft")) {
            return LENGTH_FEET * 100 * meters;
        } else if (unit.equalsIgnoreCase("mi")) {
            return LENGTH_MILES * 100 * meters;
        } else if (unit.equalsIgnoreCase("mm")) {
            return LENGTH_MILLIMETERS * 100 * meters;
        } else if (unit.equalsIgnoreCase("cm")) {
            return LENGTH_CENTIMETERS * meters;
        } else if (unit.equalsIgnoreCase("m")) {
            return LENGTH_METERS * meters;
        } else if (unit.equalsIgnoreCase("km")) {
            return LENGTH_KILOMETERS * meters;
        } else {
            throw new NotImplementedEx("This unit is not implemented , " + unit + ". Please contact the administrator!");
        }
    }

    private static double fromGrams(String unit, Double grams) {
        System.out.println("-----1 -----");
        if (unit.equalsIgnoreCase("g")) {
            return MASS_GRAM * grams;
        } else if (unit.equalsIgnoreCase("mg")) {
            return MASS_MILLIGRAM * grams;
        } else if (unit.equalsIgnoreCase("oz")) {
            return MASS_OUNCE * grams;
        } else if (unit.equalsIgnoreCase("kg")) {
            return MASS_KILOGRAM * grams;
        } else if (unit.equalsIgnoreCase("lb")) {
            return MASS_POUND * grams;
        } else if (unit.equalsIgnoreCase("st")) {
            return MASS_STONE * grams;
        } else {
            throw new NotImplementedEx("This unit is not implemented, " + unit + ". Please contact the administrator!");
        }
    }

    public static BigDecimal convertFromLengthUnitToUnit(String fromUnit, String toUnit, double value) {
        Double meters = toMeters(fromUnit, value);
        return new BigDecimal(fromMeters(toUnit, meters));
    }

    public static BigDecimal convertFromMassUnitTo(String fromUnit, String toUnit, double value) {
        Double grams = toGrams(fromUnit, value);
        return new BigDecimal(fromGrams(toUnit, grams));
    }
}
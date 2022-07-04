package lt.codeacademy.eshop;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamsDemo {

    List<Phone> phones = Arrays.asList(
            new Phone("Samsung", "S22", BigDecimal.valueOf(990)),
            new Phone("iPhone", "13 Pro", BigDecimal.valueOf(1090)),
            new Phone("Nokia", "3310", BigDecimal.valueOf(90)),
            new Phone("Samsung", "A52", BigDecimal.valueOf(390)),
            new Phone("iPhone", "3GS", BigDecimal.valueOf(50))
    );

    @Test
    void findCheapestSamsungModel() {

        imperativeProgrammingApproach(phones, "iphone");
        functionalProgrammingApproach(phones, "iphone");
    }

    private void imperativeProgrammingApproach(List<Phone> phones, String brand) {

        BigDecimal lowestPrice = BigDecimal.valueOf(Integer.MAX_VALUE);
        String cheapestModel = null;

        for (Phone phone : phones) {
            if (brand.equalsIgnoreCase(phone.getBrand())) {
                if (lowestPrice.compareTo(phone.getPrice()) > 0) {
                    lowestPrice = phone.getPrice();
                    cheapestModel = phone.getModel();
                }
            }
        }

        if (cheapestModel != null) {
            System.out.println("Pigiausias " + brand + " modelis: " + cheapestModel);
        } else {
            System.out.println(brand + " nera!");
        }
    }

    private void functionalProgrammingApproach(List<Phone> phones, String brand) {

        String model = phones.stream()
                .filter(phone -> brand.equalsIgnoreCase(phone.getBrand()))
                .sorted(new PriceComparator())
                .findFirst()
                .map(new MapModelFromPhone())
                .orElse(null);

        if (model != null) {
            System.out.println("Pigiausias " + brand + " modelis: " + model);
        } else {
            System.out.println(brand + " nera!");
        }
    }

}

class MapModelFromPhone implements Function<Phone, String> {

    @Override
    public String apply(Phone phone) {
        return phone.getModel();
    }
}

class PriceComparator implements Comparator<Phone> {

    @Override
    public int compare(Phone o1, Phone o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}

@Data
class Phone {
    private final String brand;
    private final String model;
    private final BigDecimal price;
}
package local.josiahroa.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/names")
public class CountryNames {

    @GetMapping(value="/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries(){
        CountriesApplication.countries.countryList.sort(Comparator.comparing(country -> country.getName()));
        return new ResponseEntity<>(CountriesApplication.countries.countryList, HttpStatus.OK);
    }

    @GetMapping(value="/start/{startingLetter}")
    public ResponseEntity<?> getCountriesThatStartWith(@PathVariable char startingLetter){
        List<Country> foundCountries = CountriesApplication.countries
                .getCountries(country -> country.getName().toUpperCase().charAt(0) == Character.toUpperCase(startingLetter));
        return new ResponseEntity<>(foundCountries, HttpStatus.OK);
    }

    @GetMapping(value="/size/{nameLength}")
    public ResponseEntity<?> getCountriesWithNameLength(@PathVariable int nameLength){
        List<Country> foundCountries = CountriesApplication.countries
                .getCountries(country -> country.getName().length() >= nameLength);
        return new ResponseEntity<>(foundCountries, HttpStatus.OK);
    }
}

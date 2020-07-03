package local.josiahroa.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/population")
public class CountryPopulation {

    @GetMapping(value = "/size/{populationSize}", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithPopulationSize(@PathVariable long populationSize){
        List<Country> foundCountries = CountriesApplication.countries
                .getCountries(country -> country.getPopulation() >= populationSize);
        return new ResponseEntity<>(foundCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getSmallestCountryByPopulation(){
        Country smallestCountry = CountriesApplication.countries.findMin();
        return new ResponseEntity<>(smallestCountry, HttpStatus.OK);
    }

    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getLargestCountryByPopulation(){
        Country largestCountry = CountriesApplication.countries.findMax();
        return new ResponseEntity<>(largestCountry, HttpStatus.OK);
    }
}

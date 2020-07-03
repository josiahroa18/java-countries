package local.josiahroa.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/age")
public class CountryAge {
    @GetMapping(value = "/age/{medianAge}", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithMedianAge(@PathVariable int medianAge){
        List<Country> foundCountries = CountriesApplication.countries
                .getCountries(country -> country.getMedianAge() >= medianAge);
        return new ResponseEntity<>(foundCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithSmallestMedianAge(){
        Country smallestMedianAge = CountriesApplication.countries.findMinMedianAge();
        return new ResponseEntity<>(smallestMedianAge, HttpStatus.OK);
    }

    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithLargestMedianAge(){
        Country largestMedianAge = CountriesApplication.countries.findMaxMediaAge();
        return new ResponseEntity<>(largestMedianAge, HttpStatus.OK);
    }

}

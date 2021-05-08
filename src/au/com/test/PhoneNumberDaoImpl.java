package au.com.test;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class PhoneNumberDaoImpl implements PhoneNumberDao {
    private Set<Customer> customers;

    public PhoneNumberDaoImpl(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public Set<PhoneNumber> getAllPhoneNumber() {
        return customers.stream().flatMap(c -> c.phoneNumbers().stream()).collect(Collectors.toSet());
    }

    @Override
    public Set<PhoneNumber> getPhoneNumbers(Customer customer) {

        return customers.stream().filter(x -> x == customer).flatMap(c -> c.phoneNumbers().stream()).collect(Collectors.toSet());
    }

    @Override
    public boolean activate(PhoneNumber phoneNumber) {
        Optional<Boolean> pn = customers.stream().flatMap(c -> c.phoneNumbers().stream().filter(p -> p == phoneNumber).map(PhoneNumber::activate)).findFirst();
        return pn.orElse(false);
    }
}

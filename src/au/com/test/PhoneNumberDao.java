package au.com.test;

import java.util.Set;

public interface PhoneNumberDao {
    Set<PhoneNumber> getAllPhoneNumber();
    Set<PhoneNumber> getPhoneNumbers(Customer customer);
    boolean activate(PhoneNumber phoneNumber);
}

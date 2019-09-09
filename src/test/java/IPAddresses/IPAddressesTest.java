package IPAddresses;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IPAddressesTest {
    private static List<String> addresses;

    @Test
    public void testcase1() throws Exception {
        addresses = new ArrayList<>();

        addresses.add(":");
        addresses.add(".");
        addresses.add("::::4");
        addresses.add("abc");

        assertThat(
                IPAddresses.validateAddresses(addresses)
        ).containsExactly(
                "Neither",
                "Neither",
                "Neither",
                "Neither"
        );
    }

    @Test
    public void testcase2() throws Exception {
        addresses = new ArrayList<>();

        addresses.add("0.0.0.0");
        addresses.add("1.1.1.1");
        addresses.add("255.255.255.255");
        addresses.add("256.256.256.256");
        addresses.add("-1.-1.-1.-1");
        addresses.add("0377.0377.0377.0377");
        addresses.add("0999.0999.0999.0999");
        addresses.add(".1.1.1.1");
        addresses.add("...");

        assertThat(
                IPAddresses.validateAddresses(addresses)
        ).containsExactly(
                "IPv4",
                "IPv4",
                "IPv4",
                "Neither",
                "Neither",
                "IPv4",
                "Neither",
                "Neither",
                "Neither"
        );
    }

    @Test
    public void testcase3() throws Exception {
        addresses = new ArrayList<>();

        addresses.add("::1");
        addresses.add("2001:0db8:0000:0000:0000:ff00:0042:8329");
        addresses.add("2001:db8:0:0:0:ff00:42:8329");
        addresses.add("2001:db8::ff00:42:8329");
        addresses.add("0000:0000:0000:0000:0000:0000:0000:0001");
        addresses.add("::G");
        addresses.add("::FFFFF");
        addresses.add("0001::0001::00001");
        addresses.add("01::");

        assertThat(
                IPAddresses.validateAddresses(addresses)
        ).containsExactly(
                "IPv6",
                "IPv6",
                "IPv6",
                "IPv6",
                "IPv6",
                "Neither",
                "Neither",
                "Neither",
                "Neither"
        );
    }

    @Test
    public void testcase4() throws Exception {
        addresses = new ArrayList<>();

        addresses.add("000.012.234.23");
        addresses.add("666.666.23.23");
        addresses.add(".213.123.23.32");
        addresses.add("23.45.22.32.");
        addresses.add("272:2624:235e:3bc2:c46d:682:5d46:638g");
        addresses.add("1:22:333:4444");

        assertThat(
                IPAddresses.validateAddresses(addresses)
        ).containsExactly(
                "Neither",
                "Neither",
                "Neither",
                "Neither",
                "Neither",
                "Neither"
        );
    }
}
package IPAddresses;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class IPAddresses {
    public static List<String> validateAddresses(List<String> addresses) {
        return addresses.stream()
                .map((String address) -> validateAddress(address))
                .collect(toList());
    }

    private static String validateAddress(String address) {
        boolean possiblyIPV4 = address.contains(".");
        boolean possiblyIPV6 = address.contains(":");

        if (possiblyIPV4
                && !possiblyIPV6
                && validIPV4Address(address))
            return "IPv4";

        if (possiblyIPV6
                && !possiblyIPV4
                && validIPV6Address(address))
            return "IPv6";

        return "Neither";
    }

    private static boolean validIPV4Address(String address) {
        if (address.startsWith(".") || address.endsWith("."))
            return false;

        String[] parts = address.split("\\.");

        if (parts.length != 4)
            return false;

        for (String part : parts) {
            int value = parseIPV4Part(part);

            if (value < 0 || value > 255)
                return false;
        }

        return true;
    }

    private static int parseIPV4Part(String part) {
        int base = part.charAt(0) == '0' ? 8 : 10;

        try {
            int value = Integer.parseInt(part, base);

            if (base == 8 && value >= 8)
                return -1;

            return value;
        } catch(NumberFormatException numberFormatError) {
            return -1;
        }
    }

    private static boolean validIPV6Address(String address) {
        String[] splitByDoubleColons = address.split("::");
        int pairsOfColons = splitByDoubleColons.length - 1;

        if (pairsOfColons > 1)
            return false;

        if (pairsOfColons == 1)
            return validIPV6AddressParts(splitByDoubleColons[0], false)
                    && validIPV6AddressParts(splitByDoubleColons[1], false);

        return validIPV6AddressParts(address);
    }

    private static boolean validIPV6AddressParts(String addressParts) {
        return validIPV6AddressParts(addressParts, true);
    }

    private static boolean validIPV6AddressParts(
            String addressParts,
            boolean complete
    ) {
        if (!complete && addressParts.equals(""))
            return true;

        String[] parts = addressParts.split(":");

        if (complete && parts.length != 8)
            return false;

        for (String part : parts) {
            int value = parseIPV6Part(part);

            if (value < 0 || value > 65536)
                return false;
        }

        return true;
    }

    private static int parseIPV6Part(String part) {
        try {
            return Integer.parseInt(part, 16);
        } catch(NumberFormatException numberFormatError) {
            return -1;
        }
    }
}

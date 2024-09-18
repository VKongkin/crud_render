package kongkin.bbu.edu.crud.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class IpAddressController {

    @GetMapping("/client-ip")
    public String getClientIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");

        // Check if the X-Forwarded-For header is present
        if (ipAddress != null && !ipAddress.isEmpty() && !"unknown".equalsIgnoreCase(ipAddress)) {
            // X-Forwarded-For can contain a list of IPs, we only want the first one (original client)
            ipAddress = ipAddress.split(",")[0];
        } else {
            // If no X-Forwarded-For, fall back to getRemoteAddr
            ipAddress = request.getRemoteAddr();
        }

        // If the IP is IPv6 loopback, return 127.0.0.1 instead
        if ("0:0:0:0:0:0:0:1".equals(ipAddress)) {
            ipAddress = "127.0.0.1";
        }

        // Return the IP address (filtering for IPv4 if necessary)
        return "Client IP: " + ipAddress;
    }
}

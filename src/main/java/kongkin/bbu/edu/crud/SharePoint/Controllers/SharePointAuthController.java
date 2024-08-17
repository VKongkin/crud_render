package kongkin.bbu.edu.crud.SharePoint.Controllers;

import kongkin.bbu.edu.crud.SharePoint.Models.AccessTokenResponse;
import kongkin.bbu.edu.crud.SharePoint.Services.SharePointAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sharepoint")
public class SharePointAuthController {

    @Autowired
    private SharePointAuthService sharePointAuthService;



    @GetMapping("/token")
    public AccessTokenResponse getAccessToken() {
        return sharePointAuthService.getAccessToken();
    }

    @GetMapping("/test")
    public String getToken(){
        String accessToken = sharePointAuthService.getAccessToken().getAccess_token();
        return accessToken;
    }



}

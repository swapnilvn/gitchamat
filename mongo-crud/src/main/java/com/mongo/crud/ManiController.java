package com.mongo.crud;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class ManiController {

    private final ManiService maniService;

    public ManiController(ManiService maniService) {
        this.maniService = maniService;
    }

    // Define your endpoints here
    @GetMapping("/manis")
    public List<Mani> getAllManis() {
        return maniService.getAllManis();
    }

    @PostMapping("/save")
    public Mani saveMani(@RequestBody Mani mani) {
        return maniService.saveMani(mani);
    }

    @GetMapping("/getManiByName")
    public Mani getManiByName(@RequestHeader( value = "X-Client-Id", required = false) String clientId, @RequestParam("name") String name) {
        logClientId(clientId);
        return maniService.getManiByName(name);
    }

    @GetMapping("/getManiByStore")
    public List<Mani> getManiByStore(HttpServletRequest httpServletRequest) {
        String header = httpServletRequest.getHeader("X-Client-Id");
        logClientId(header);
        return maniService.getManiByStore( (null != header && !header.isEmpty()) ? header : null);
    }

    private void logClientId(String clientId) {
        log.info("X-Client-Id : {}", String.valueOf(clientId));
    }
}

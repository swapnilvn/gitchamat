package com.postgres.crud.h2database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/sony")
public class SonyController {

    @Autowired
    SonyService sonyService;

    @PostMapping("/save")
    public Sony saveSony(@RequestBody Sony sony)
    {
        return sonyService.saveSony(sony);
    }

    @GetMapping("/get")
    public Sony getSonyById(@RequestParam ("id") Long id)
    {
        return sonyService.getSonyById(id);
    }

    @DeleteMapping("/delete")
    public void deleteSonyById(@RequestParam ("id") Long id)
    {
        sonyService.deleteSonyById(id);
    }

    @GetMapping("/getall")
    public List<Sony> getAllSony()
    {
        return sonyService.getAllSony();
    }

    @PutMapping("/putupdate")
    public Sony putUpdate(@RequestBody Sony sony)
    {
        return sonyService.putUpdate(sony);
    }

    @PatchMapping("/patchupdate")
    public Sony patchUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates)
    {
        return sonyService.patchUpdate(id, updates);
    }
}

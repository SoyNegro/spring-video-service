package com.thedarksideofcode.audiostreamer

import org.springframework.core.io.UrlResource
import org.springframework.core.io.support.ResourceRegion
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import java.nio.file.Paths

@RestController
class StreamerApi(val service: StreamerService) {

    @GetMapping("/files/{name}")
    fun getFile(@PathVariable name:String, @RequestHeader httpHeaders: HttpHeaders): ResponseEntity<ResourceRegion>{
        val file = UrlResource(Paths.get("filespath$name").toUri())
        val region = service.resourceRegion(file,httpHeaders)
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).contentType(MediaTypeFactory.getMediaType(file).orElse(
            MediaType.APPLICATION_OCTET_STREAM)).cacheControl(CacheControl.noCache()).body(region)
    }
}
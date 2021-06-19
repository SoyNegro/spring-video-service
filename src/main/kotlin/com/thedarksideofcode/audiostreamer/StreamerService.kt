package com.thedarksideofcode.audiostreamer

import org.springframework.core.io.UrlResource
import org.springframework.core.io.support.ResourceRegion
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Service
import java.lang.Long.min

@Service
class StreamerService {
    fun resourceRegion(urlResource: UrlResource, headers: HttpHeaders): ResourceRegion {
        val contentLength = urlResource.contentLength()
        val range = headers.range.firstOrNull()
        return if (range != null) {
            val start = range.getRangeStart(contentLength)
            val end = range.getRangeEnd(contentLength)
            val rangeLength = min(ChunkSize, end - start + 1)
            ResourceRegion(urlResource, start, rangeLength)
        } else {
            val rangeLength = min(ChunkSize, contentLength)
            ResourceRegion(urlResource, 0, rangeLength)
        }
    }

    companion object {
        const val ChunkSize = 1000000L
    }
}
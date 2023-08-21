package com.vibhusha.service;

public record Blog(Long id,
                   String name,
                   String image,
                   String title,

                   String content,
                   String author,
                   String publicationDate) {
}

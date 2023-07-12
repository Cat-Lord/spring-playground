package sk.catheaven.jpa.playground.controllers.mappers;

import org.springframework.stereotype.Service;

@Service
public interface ModelMapper<Model, Request, Response> {

    // Create model from a request, update any property that can be updated
    Model toModel(Model original, Request request);

    // In case there was no previous
    Model toModel(Request request);

    Response toResponse(Model model);
}

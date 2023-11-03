package com.oppscience.ingestion;

import com.oppscience.ingestion.model.MyEntity;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Path("/hello")
@Slf4j
public class GreetingResource {
  @Inject EntityManager em;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "Hello RESTEasy";
  }

  @PUT
  @Path("/create")
  @Produces(MediaType.TEXT_PLAIN)
  @Transactional
  public String create() {
    MyEntity entity1 = new MyEntity();
    entity1.field = "field-1";
    log.info("BEFORE Entity: " + entity1);

    em.persist(entity1);

    log.info("AFTER Entity: " + entity1);

    List<MyEntity> entities = em.createQuery("from MyEntity", MyEntity.class).getResultList();

    log.info("Entities: " + entities);

    return "Hello RESTEasy";
  }
}

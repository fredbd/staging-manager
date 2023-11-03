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
import java.io.File;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/dataflow/{dataflowId}/staging/file")
@Slf4j
public class FileResource {
  @Inject EntityManager em;

  @GET
  @Path("/list")
  @Produces(MediaType.TEXT_PLAIN)
  @Transactional
  public String list(@PathParam String dataflowId) {
    List<File> files = em.createQuery("from File", File.class).getResultList();

    log.info("[" + dataflowId + "] Files: " + files);

    return "Hello RESTEasy";
  }
}

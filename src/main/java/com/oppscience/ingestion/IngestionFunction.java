package com.oppscience.ingestion;

import io.quarkus.funqy.knative.events.CloudEvent;
import io.quarkus.funqy.knative.events.CloudEventBuilder;
import java.util.Map;
import lombok.Getter;

public class IngestionFunction<R> {

  @Getter
  protected final String outputType;

  public IngestionFunction(String defaultOutputType) {
    String envOutputType = System.getenv("KNATIVE_OUTPUT_TYPE");
    this.outputType = (envOutputType == null)? defaultOutputType : envOutputType;
  }

  protected CloudEvent<R> buildResponse(R result) {
    return buildResponse(result, Map.of());
  }

  protected CloudEvent<R> buildResponse(R result, Map<String, String> headers) {
    return CloudEventBuilder.create()
      .type(getOutputType())
      .extensions(headers)
      .build(result);
  }
}

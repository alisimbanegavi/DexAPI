package com.DexAPI.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CatalogueDTO {
  private static final long serialVersionUID = 5926468583005150707L;

  private String name;
  private String userId;
  private String description;

}

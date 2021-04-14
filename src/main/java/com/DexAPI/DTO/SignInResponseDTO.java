package com.DexAPI.DTO;

public class SignInResponseDTO {

    private static final long serialVersionUID = -8091879091924046844L;
    private String jwttoken = "";
    public SignInResponseDTO(String token, UserResponseDTO userResponseDTO) {
        this.jwttoken= token;
        this.user = userResponseDTO;
    }
    public String getJwttoken() {
        return jwttoken;
    }
    public UserResponseDTO getUser() {
        return user;
    }
    private UserResponseDTO user = new UserResponseDTO();
}

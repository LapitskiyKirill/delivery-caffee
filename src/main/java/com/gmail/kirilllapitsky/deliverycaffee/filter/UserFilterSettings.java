package com.gmail.kirilllapitsky.deliverycaffee.filter;

import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFilterSettings {
    private Optional<Long> cafeId;
    private Optional<Role> role;
}

package shop.buyAndSell.quickr.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data

@Document("user")
public class User {

  @Id
  private String Id;
  private String name;
  private String email;
  private String password;
  private long phone;
  private String address;

  private String city;
  private String state;
  private String country;
   

}

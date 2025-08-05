package org.suhariki.inscription.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.suhariki.inscription.models.Card;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class MainRepository {
    private final JdbcTemplate jdbcTemplate;

    public MainRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean CheckAuthentication(String username, String password) {
        return true;
    }

    public Optional<Card> getCardById(String id){
        String sql = "SELECT * FROM public.cards where id = ?";
        List<Card> results = jdbcTemplate.query(sql, this::returnCard, id);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    private Card returnCard(ResultSet row, int rowNum) throws SQLException {
        Card newCard = new Card();
        newCard.setCardId(Integer.parseInt(row.getString("cardid")));
        newCard.setCardName((row.getString("cardname")));
        newCard.setCardHp((byte) Integer.parseInt(row.getString("cardhp")));
        newCard.setCardDMG((byte) Integer.parseInt(row.getString("carddmg")));
        newCard.setCardCost((byte) Integer.parseInt(row.getString("cardcost")));
        newCard.setCardRare(Integer.parseInt(row.getString("cardrare")) == 1);
        newCard.setCardCostType((row.getString("cardcosttype")));
        newCard.setCardRace((row.getString("cardrace")));
        newCard.setCardHandable(Integer.parseInt(row.getString("cardrace")) == 1);
        return newCard;
    }

}

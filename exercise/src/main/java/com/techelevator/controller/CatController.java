package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @GetMapping ("/api/cards")
    public List<CatCard> list () {
        return catCardDao.list();
    }

    @GetMapping ("/api/cards/{id}")
    public CatCard get(@PathVariable long id) {
        CatCard card = catCardDao.get(id);
        if (card == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cat card not found.");
        } else {
            return this.catCardDao.get(id);
        }
    }

   @PostMapping ()
    public boolean save(CatCard cardToSave) {

        return catCardDao.save(cardToSave);
   }

   @PutMapping ("/api/cards/{id}")
    public boolean update(@PathVariable long id, @Valid @RequestBody CatCard card) {
         card = this.catCardDao.get(id);

        if (card == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Card not found.");
        }
        return this.catCardDao.update(id, card);
   }

   @DeleteMapping ("/api/cards/{id}")
    public void delete(@PathVariable long id) {
        CatCard card = this.catCardDao.get(id);

        if (card == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Card not found.");
        }
        this.catCardDao.delete(id);
   }

   @GetMapping("/api/cards/random")
    public CatCard createRandomCatCard() {
       CatPic catPic = catPicService.getPic();
       CatFact catFact = catFactService.getFact();

       CatCard createdCatCard = null;
       createdCatCard.getCatFact(catFact);
       createdCatCard.getImgUrl(catPic.);

   }


}

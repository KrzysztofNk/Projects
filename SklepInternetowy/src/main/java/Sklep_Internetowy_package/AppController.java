package Sklep_Internetowy_package;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AppController {

    @Autowired
    private ProduktyDAO produktyDAO;

    @Autowired
    private PracownicyDAO pracownicyDAO;

    @Autowired
    private MagazynyDAO magazynyDAO;


    @RequestMapping(value = "/")
    public String sampleMethod(SecurityContextHolderAwareRequestWrapper requestWrapper, Model model)
    {
        if( requestWrapper.isUserInRole("ROLE_ADMIN"))
        {
            return "redirect:/list/produkty/admin";
        }

       return "redirect:/list/produkty/user";
    }



    @RequestMapping("/list/produkty/admin")
    public String viewProduktyPageAdmin(Model model) {
        List<Produkt> ProduktyList = produktyDAO.list();
        model.addAttribute("ProduktyList",ProduktyList);
        return "produktywidokadmina";
    }


    @RequestMapping("/list/produkty/user")
    public String viewProduktyPageUser(Model model) {
        List<Produkt> ProduktyList = produktyDAO.list();
        model.addAttribute("ProduktyList",ProduktyList);
        return "produktywidokpracownika";
    }

    @RequestMapping("/list/pracownicy")
    public String viewPracownicyPage(Model model) {
        List<Pracownik> PracownicyList = pracownicyDAO.list();
        model.addAttribute("PracownicyList",PracownicyList);
        return "pracownicy";
    }

    @RequestMapping("/list/magazyny")
    public String viewMagazynyPage(Model model) {
        List<Magazyn> MagazynyList = magazynyDAO.list();
        model.addAttribute("MagazynyList",MagazynyList);
        return "magazyny";
    }


    @RequestMapping("/new/produkt/admin")
    public String addProduktyAdmin(Model model) {
        Produkt produkt = new Produkt();
        model.addAttribute("produkt",produkt);
        return "dodajprodukt";
    }


    @RequestMapping("/new/produkt/user")
    public String addProduktyUser(Model model) {
        Produkt produkt = new Produkt();
        model.addAttribute("produkt",produkt);
        return "dodajproduktpracownik";
    }

    @RequestMapping("/new/pracownik")
    public String addPracownicy(Model model) {
        Pracownik pracownik = new Pracownik();
        model.addAttribute("pracownik",pracownik);
        return "dodajpracownika";
    }

    @RequestMapping("/new/magazyn")
    public String addMagazyny(Model model) {
        Magazyn magazyn = new Magazyn();
        model.addAttribute("magazyn",magazyn);
        return "dodajmagazyn";
    }


    @RequestMapping(value = "/save/produkt/admin", method = RequestMethod.POST)
    public String saveProduktyAdmin(@ModelAttribute("produkt") Produkt produkt) {
        try {
            produktyDAO.save(produkt);
        }

        catch(java.lang.Exception e){
            System.err.println(e);
            return "dodajproduktblad";
        }
        return "redirect:/list/produkty/admin";
    }

    @RequestMapping(value = "/save/produkt/user", method = RequestMethod.POST)
    public String saveProduktyUser(@ModelAttribute("produkt") Produkt produkt) {
        try {
            produktyDAO.save(produkt);
        }

        catch(java.lang.Exception e){
            System.err.println(e);
            return "dodajproduktpracownikblad";
        }
        return "redirect:/list/produkty/user";
    }


    @RequestMapping(value = "/save/pracownik", method = RequestMethod.POST)
    public String savePracownik(@ModelAttribute("pracownik") Pracownik pracownik) {
       try{
           pracownicyDAO.save(pracownik);
       }
       catch(java.lang.Exception e){
           System.err.println(e);
           return "dodajpracownikablad";
       }
        return "redirect:/list/pracownicy";
    }

    @RequestMapping(value = "/save/magazyn", method = RequestMethod.POST)
    public String saveMagazyny(@ModelAttribute("magazyn") Magazyn magazyn) {
       try
       {
           magazynyDAO.save(magazyn);
       }

       catch(java.lang.Exception e){
           System.err.println(e);
           return "dodajmagazynblad";
       }
        return "redirect:/list/magazyny";
    }


    @RequestMapping("/edit/produkt/admin/{produkt_id}")
    public ModelAndView editPraoduktAdmin(@PathVariable(name = "produkt_id") int produkt_id) {
        ModelAndView mav = new ModelAndView("edycjaproduktu");
        Produkt produkt = produktyDAO.get(produkt_id);
        mav.addObject("produkt", produkt);
        return mav;
    }

    @RequestMapping("/edit/produkt/user/{produkt_id}")
    public ModelAndView editPraoduktUser(@PathVariable(name = "produkt_id") int produkt_id) {
        ModelAndView mav = new ModelAndView("edycjaproduktupracownik");
        Produkt produkt = produktyDAO.get(produkt_id);
        mav.addObject("produkt", produkt);
        return mav;
    }

    @RequestMapping("/edit/pracownik/{pracownik_id}")
    public ModelAndView editPracownik(@PathVariable(name = "pracownik_id") int pracownik_id) {
        ModelAndView mav = new ModelAndView("edycjapracownika");
        Pracownik pracownik = pracownicyDAO.get(pracownik_id);
        mav.addObject("pracownik", pracownik);
        return mav;
    }

    @RequestMapping("/edit/magazyn/{magazyn_id}")
    public ModelAndView editMagazyn(@PathVariable(name = "magazyn_id") int magazyn_id) {
        ModelAndView mav = new ModelAndView("edycjamagazynu");
        Magazyn magazyn = magazynyDAO.get(magazyn_id);
        mav.addObject("magazyn", magazyn);
        return mav;
    }


    @RequestMapping(value = "/update/produkt/admin", method = RequestMethod.POST)
    public String updateProduktyAdmin(@ModelAttribute("produkt") Produkt produkt) {
        try{
            produktyDAO.update(produkt);
        }

        catch(java.lang.Exception e){
            System.err.println(e);
            return "edycjaproduktublad";
        }
        return "redirect:/list/produkty/admin";
    }


    @RequestMapping(value = "/update/produkt/user", method = RequestMethod.POST)
    public String updateProduktyUser(@ModelAttribute("produkt") Produkt produkt) {
        try{
            produktyDAO.update(produkt);
        }

        catch(java.lang.Exception e){
            System.err.println(e);
            return "edycjaproduktupracownikblad";
        }
        return "redirect:/list/produkty/user";
    }

    @RequestMapping(value = "/update/pracownik", method = RequestMethod.POST)
    public String updatePracownicy(@ModelAttribute("pracownik") Pracownik pracownik) {
        try{
            pracownicyDAO.update(pracownik);
        }
        catch(java.lang.Exception e){
            System.err.println(e);
            return "edycjapracownikablad";
        }
        return "redirect:/list/pracownicy";
    }

    @RequestMapping(value = "/update/magazyn", method = RequestMethod.POST)
    public String updateMagazyny(@ModelAttribute("magazyn") Magazyn magazyn) {
       try{
           magazynyDAO.update(magazyn);
       }

       catch(java.lang.Exception e){
           System.err.println(e);
           return "edycjamagazynublad";
       }
        return "redirect:/list/magazyny";
    }


    @RequestMapping("/delete/produkt/admin/{produkt_id}")
    public String deleteProduktyAdmin(@PathVariable(name = "produkt_id") int produkt_id) {
        produktyDAO.delete(produkt_id);

        return "redirect:/list/produkty/admin";
    }

    @RequestMapping("/delete/produkt/user/{produkt_id}")
    public String deleteProduktyUser(@PathVariable(name = "produkt_id") int produkt_id) {
        produktyDAO.delete(produkt_id);

        return "redirect:/list/produkty/user";
    }

    @RequestMapping("/delete/pracownik/{pracownik_id}")
    public String deletePracownicy(@PathVariable(name = "pracownik_id") int pracownik_id) {
        pracownicyDAO.delete(pracownik_id);
        return "redirect:/list/pracownicy";
    }


    @RequestMapping("/delete/magazyn/{magazyn_id}")
    public String deleteMagazyny(@PathVariable(name = "magazyn_id") int magazyn_id) {
        magazynyDAO.delete(magazyn_id);
        return "redirect:/list/magazyny";
    }



    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }



    @RequestMapping("/logout")
    public String logout(Model model) {
        return "redirect:/login?logout";
    }



}
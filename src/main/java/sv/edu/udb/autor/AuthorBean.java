/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.autor;

import sv.edu.udb.autores.model.AuthorModel;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sv.edu.udb.autores.model.Author;
import sv.edu.udb.autores.model.LiteraryGenreModel;

        
/**
 *
 * @author raque
 */
@ManagedBean
@SessionScoped

    public class AuthorBean implements Serializable {
 private Author author;
 private AuthorModel authorModel = new AuthorModel();
 private LiteraryGenreModel literaryGenreModel = new LiteraryGenreModel();
 
 
 public AuthorBean() {
 this.author = new Author();
 }
 
 public void addAuthor() throws SQLException{
 authorModel.addAuthor(author);
 FacesContext.getCurrentInstance().addMessage("successMessage", new
FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado Exitosamente", "Agregado"));
 author = new Author();
 }
 
 public void deleteAuthor(Author author) throws SQLException{
 authorModel.delete(author);
 }
 
 public void countAuthor(String name) throws SQLException{
 if(authorModel.findSameNameAuhor(name)>0){
 FacesContext.getCurrentInstance().addMessage("errorMessage", new
FacesMessage(FacesMessage.SEVERITY_INFO, "Este autor ya existe", "Author"));
 }
    
}
 
  public Author getAuthor() {
 return author;
 }
 /**
 * @param author the author to set
 */
 public void setAuthor(Author author) {
 this.author = author;
 }
 /**
 * @return the authorModel
 */
 public AuthorModel getAuthorModel() {
 return authorModel;
 }
 /**
 * @param authorModel the authorModel to set
 */
 public void setAuthorModel(AuthorModel authorModel) {
 this.authorModel = authorModel;
 }
 /**
 * @return the literaryGenreModel
 */
 public LiteraryGenreModel getLiteraryGenreModel() {
 return literaryGenreModel;
 }
 /**
 * @param literaryGenreModel the literaryGenreModel to set
*/
 public void setLiteraryGenreModel(LiteraryGenreModel literaryGenreModel) {
 this.literaryGenreModel = literaryGenreModel;
 }
}

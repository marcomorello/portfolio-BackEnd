/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.mm.Interface;

import com.portfolio.mm.Entity.Persona;
import java.util.List;

/**
 *
 * @author marco
 */
public interface IPersonaService {
    // Para traer una lista de personas
    public List<Persona> getPersona();
    // Guarda un objeto de tipo persona
    public void savePersona(Persona persona);
    // Eliminar un usuario
    public void deletePersona(Long id);
    // Buscar una persona por id
    public Persona findPersona(Long id);
}

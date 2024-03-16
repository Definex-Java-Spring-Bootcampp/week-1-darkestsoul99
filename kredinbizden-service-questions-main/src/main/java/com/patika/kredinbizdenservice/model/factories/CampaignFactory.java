/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patika.kredinbizdenservice.model.factories;

import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.model.Campaign;
import java.time.LocalDate;

/**
 *
 * @author berke
 */
public class CampaignFactory {
    public static Campaign createCampaign(String title, String content, LocalDate dueDate, LocalDate createDate, LocalDate updateDate, SectorType sector) {
        return new Campaign(title, content, dueDate, createDate, updateDate, sector);
    }
}

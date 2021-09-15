package com.example.skyfirebase;

public class model {
    String m_id;
    String m_name;
    String m_mob;
    String m_details;

    public model(String m_id, String m_name, String m_mob, String m_details) {
        this.m_id = m_id;
        this.m_name = m_name;
        this.m_mob = m_mob;
        this.m_details = m_details;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_mob() {
        return m_mob;
    }

    public void setM_mob(String m_mob) {
        this.m_mob = m_mob;
    }

    public String getM_details() {
        return m_details;
    }

    public void setM_details(String m_details) {
        this.m_details = m_details;
    }
}

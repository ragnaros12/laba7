package org.example.command;

import org.example.Main;
import org.example.objects.HumanBeing;
import org.example.objects.WeaponType;

public class MinByWeaponType extends Command{
    @Override
    public void Execute(Object[] args) {
        for (HumanBeing humanBeing : Main.manager.getHumanBeings()){
            if(humanBeing.getWeaponType() == WeaponType.HAMMER){
                Main.console.Write(humanBeing.toString());
                return;
            }
        }
        Main.console.Write("такого элемента не существует");
    }

    @Override
    public String getDesc() {
        return "min_by_weapon_type : вывести любой объект из коллекции, значение поля weaponType которого является минимальным\n";
    }
}

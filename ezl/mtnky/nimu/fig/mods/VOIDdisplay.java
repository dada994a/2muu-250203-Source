package ezl.mtnky.nimu.fig.mods;

import ezl.mtnky.nimu.nimuclient;
import ezl.mtnky.nimu.fig.Luna;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

public class VOIDdisplay {
   @SubscribeEvent
   public void a(RenderTickEvent e) {
      if (Minecraft.getMinecraft().currentScreen instanceof GuiChat || Minecraft.getMinecraft().currentScreen == null) {
         String voids = "§e§lSession Voids: §f" + nimuclient.voids;
         int textWidthz = Minecraft.getMinecraft().fontRendererObj.getStringWidth(voids);
         if (Luna.voidShown) {
            Gui.drawRect(Luna.VOIDposX - 5, Luna.VOIDposY - 5, Luna.VOIDposX + textWidthz + 5, Luna.VOIDposY + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT + 4, Luna.VOIDB ? -2013265920 : 0);
         }

         if (Luna.voidShown) {
            float var10002 = (float)Luna.VOIDposX;
            float var10003 = (float)Luna.VOIDposY;
            Minecraft.getMinecraft().fontRendererObj.drawString(voids, var10002, var10003, 16777215, true);
         }

      }
   }
}

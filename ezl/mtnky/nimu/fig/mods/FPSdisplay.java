package ezl.mtnky.nimu.fig.mods;

import ezl.mtnky.nimu.fig.Luna;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

public class FPSdisplay {
   @SubscribeEvent
   public void a(RenderTickEvent e) {
      if (Minecraft.getMinecraft().currentScreen instanceof GuiChat || Minecraft.getMinecraft().currentScreen == null) {
         String fpsText = "FPS: " + Minecraft.getDebugFPS();
         int textWidthz = Minecraft.getMinecraft().fontRendererObj.getStringWidth(fpsText);
         if (Luna.FPSShown) {
            Gui.drawRect(Luna.FPSposX - 5, Luna.FPSposY - 5, Luna.FPSposX + textWidthz + 5, Luna.FPSposY + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT + 4, Luna.fpsB ? -2013265920 : 0);
         }

         if (Luna.FPSShown) {
            float var10002 = (float)Luna.FPSposX;
            float var10003 = (float)Luna.FPSposY;
            Minecraft.getMinecraft().fontRendererObj.drawString(fpsText, var10002, var10003, 16777215, true);
         }

      }
   }
}

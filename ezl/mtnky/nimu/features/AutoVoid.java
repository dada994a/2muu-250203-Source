package ezl.mtnky.nimu.features;

import ezl.mtnky.nimu.nimuclient;
import ezl.mtnky.nimu.fig.ModConfig;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

public class AutoVoid {
   @SubscribeEvent
   public void listenr(ClientChatReceivedEvent e) {
      String A = e.message.getUnformattedText().replaceAll("§([0-9a-f]|r|l|o|n|m|k)", "");
      if (!A.contains(":") && A.contains(Minecraft.getMinecraft().thePlayer.getDisplayNameString().replaceAll("§([0-9a-f]|r|l|o|n|m|k)", "") + " fell into the void.")) {
         ++nimuclient.voids;
      }

   }

   @SubscribeEvent
   public void WaterMark(RenderTickEvent e) {
      if (Minecraft.getMinecraft().currentScreen == null || Minecraft.getMinecraft().currentScreen instanceof GuiChat) {
         ScaledResolution scaledResolution = new ScaledResolution(nimuclient.mc);
         if (Minecraft.getMinecraft().thePlayer != null) {
            Minecraft mc = Minecraft.getMinecraft();
            FontRenderer fontRenderer = Minecraft.getMinecraft().fontRendererObj;
            String TXT = !ModConfig.avoidmode ? "Auto Void" : "Auto Void §7Hypixel";
            String TXT2 = !ModConfig.aflagmode ? "Auto Flag Collect" : "Auto Flag Collect §7Vanilla";
            if (ModConfig.aflag) {
               fontRenderer.drawStringWithShadow(TXT2, (float)(scaledResolution.getScaledWidth() - 2 - fontRenderer.getStringWidth(TXT2)), 2.0F, ModConfig.aflagchrma ? getChroma(3L) : 3372287);
            }

            if (ModConfig.avoid && ModConfig.aflag) {
               fontRenderer.drawStringWithShadow(TXT, (float)(scaledResolution.getScaledWidth() - 2 - fontRenderer.getStringWidth(TXT)), (float)(4 + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT), ModConfig.avoidchrma ? getChroma(3L) : 3372287);
            }

            if (ModConfig.avoid && !ModConfig.aflag) {
               fontRenderer.drawStringWithShadow(TXT, (float)(scaledResolution.getScaledWidth() - 2 - fontRenderer.getStringWidth(TXT)), 2.0F, ModConfig.avoidchrma ? getChroma(3L) : 3372287);
            }

         }
      }
   }

   public static int getChroma(long speed, long... delay) {
      long time = System.currentTimeMillis() + (delay.length > 0 ? delay[0] : 0L);
      return Color.getHSBColor((float)(time % (15000L / speed)) / (15000.0F / (float)speed), 1.0F, 1.0F).getRGB();
   }
}

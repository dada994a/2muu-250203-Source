package ezl.mtnky.nimu.fig;

import ezl.mtnky.nimu.nimuclient;
import ezl.mtnky.nimu.fig.gui.Cosme;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;

public class Luna extends GuiScreen {
   public static boolean fpsB;
   public static boolean FPSShown;
   public static boolean VOIDB;
   public static boolean voidShown;
   private int buttonX;
   private int buttonY;
   private int buttonWidth;
   private int buttonHeight;
   private int buttonX2;
   private int buttonY2;
   private int buttonWidth2;
   private int buttonHeight2;
   private static Minecraft mc = Minecraft.getMinecraft();
   public static int FPSposX = 10;
   public static int FPSposY = 10;
   public static int VOIDposX = 10;
   public static int VOIDposY = 30;
   private boolean dragging;
   private boolean dragging2 = false;
   private int lastMouseX;
   private int lastMouseY;

   public void initGui() {
      super.initGui();
      this.buttonWidth = 100;
      this.buttonHeight = 20;
      this.buttonX = this.width / 2 - this.buttonWidth / 2;
      this.buttonY = this.height / 2 - this.buttonHeight / 2;
      this.buttonWidth2 = 20;
      this.buttonHeight2 = 20;
      this.buttonX2 = this.width / 2 - this.buttonWidth / 2 + 110;
      this.buttonY2 = this.height / 2 - this.buttonHeight / 2;
   }

   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
      drawRect(this.buttonX, this.buttonY, this.buttonX + this.buttonWidth, this.buttonY + this.buttonHeight, 1157627903);
      drawRect(this.buttonX, this.buttonY, this.buttonX + this.buttonWidth, this.buttonY + 2, -5592406);
      drawRect(this.buttonX, this.buttonY, this.buttonX + 2, this.buttonY + this.buttonHeight, -5592406);
      drawRect(this.buttonX + this.buttonWidth - 2, this.buttonY, this.buttonX + this.buttonWidth, this.buttonY + this.buttonHeight, -5592406);
      drawRect(this.buttonX, this.buttonY + this.buttonHeight - 2, this.buttonX + this.buttonWidth, this.buttonY + this.buttonHeight, -5592406);
      drawRect(this.buttonX2, this.buttonY2, this.buttonX2 + this.buttonWidth2, this.buttonY2 + this.buttonHeight2, 1157627903);
      drawRect(this.buttonX2, this.buttonY2, this.buttonX2 + this.buttonWidth2, this.buttonY2 + 2, -5592406);
      drawRect(this.buttonX2, this.buttonY2, this.buttonX2 + 2, this.buttonY2 + this.buttonHeight2, -5592406);
      drawRect(this.buttonX2 + this.buttonWidth2 - 2, this.buttonY2, this.buttonX2 + this.buttonWidth2, this.buttonY2 + this.buttonHeight2, -5592406);
      drawRect(this.buttonX2, this.buttonY2 + this.buttonHeight2 - 2, this.buttonX2 + this.buttonWidth2, this.buttonY2 + this.buttonHeight2, -5592406);
      String buttonText = "MODS";
      int textWidth = this.fontRendererObj.getStringWidth(buttonText);
      int textX = this.buttonX + (this.buttonWidth - textWidth) / 2;
      int textY = this.buttonY + (this.buttonHeight - this.fontRendererObj.FONT_HEIGHT) / 2 + 2;
      this.fontRendererObj.drawString(buttonText, (float)textX, (float)textY, 16777215, true);
      String buttonText2 = "C";
      int textWidth2 = this.fontRendererObj.getStringWidth(buttonText2);
      int textX2 = this.buttonX2 + (this.buttonWidth2 - textWidth2) / 2;
      int textY2 = this.buttonY2 + (this.buttonHeight2 - this.fontRendererObj.FONT_HEIGHT) / 2 + 2;
      this.fontRendererObj.drawString(buttonText2, (float)textX2, (float)textY2, 16777215, true);
      Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("§b§lに§rむくらいあんと", (float)(this.width - 1 - Minecraft.getMinecraft().fontRendererObj.getStringWidth("§lに§rむくらいあんと")), (float)(this.height - 1 - Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT), 4368603);
      String fpsText = "FPS: " + Minecraft.getDebugFPS();
      int textWidthz = this.fontRendererObj.getStringWidth(fpsText);
      drawRect(FPSposX - 5, FPSposY - 5, FPSposX + textWidthz + 5, FPSposY + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT + 4, fpsB ? -2013265920 : 0);
      this.fontRendererObj.drawString(fpsText, (float)FPSposX, (float)FPSposY, 16777215, true);
      if (this.dragging) {
         FPSposX += mouseX - this.lastMouseX;
         FPSposY += mouseY - this.lastMouseY;
         this.lastMouseX = mouseX;
         this.lastMouseY = mouseY;
      }

      String voids = "§e§lSession Voids: §f" + nimuclient.voids;
      int textWidthz2 = this.fontRendererObj.getStringWidth(voids);
      drawRect(VOIDposX - 5, VOIDposY - 5, VOIDposX + textWidthz2 + 5, VOIDposY + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT + 4, VOIDB ? -2013265920 : 0);
      this.fontRendererObj.drawString(voids, (float)VOIDposX, (float)VOIDposY, 16777215, true);
      if (this.dragging2) {
         VOIDposX += mouseX - this.lastMouseX;
         VOIDposY += mouseY - this.lastMouseY;
         this.lastMouseX = mouseX;
         this.lastMouseY = mouseY;
      }

      super.drawScreen(mouseX, mouseY, partialTicks);
   }

   protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
      if (this.isMouseOver(mouseX, mouseY)) {
         mc.displayGuiScreen(new ModConfigGUI(this));
      }

      if (this.isMouseOver2(mouseX, mouseY)) {
         mc.displayGuiScreen(new Cosme(this));
      }

      String fpsText;
      int textWidth;
      String voids;
      int textWidthz2;
      if (mouseButton == 0) {
         fpsText = "FPS: " + Minecraft.getDebugFPS();
         textWidth = this.fontRendererObj.getStringWidth(fpsText);
         voids = "§e§lSession Voids: §f" + nimuclient.voids;
         textWidthz2 = this.fontRendererObj.getStringWidth(voids);
         if (Keyboard.isKeyDown(42)) {
            if (mouseX >= FPSposX && mouseX <= FPSposX + textWidth && mouseY >= FPSposY && mouseY <= FPSposY + 10) {
               FPSShown = !FPSShown;
               Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§8[§bN§8] §7FPS display: " + (FPSShown ? "§aShown" : "§cHidden")));
            }

            if (mouseX >= VOIDposX && mouseX <= VOIDposX + textWidthz2 && mouseY >= VOIDposY && mouseY <= VOIDposY + 10) {
               voidShown = !voidShown;
               Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§8[§bN§8] §7Void display: " + (voidShown ? "§aShown" : "§cHidden")));
            }
         } else {
            if (mouseX >= FPSposX && mouseX <= FPSposX + textWidth && mouseY >= FPSposY && mouseY <= FPSposY + 10) {
               this.dragging = true;
               this.lastMouseX = mouseX;
               this.lastMouseY = mouseY;
            }

            if (mouseX >= VOIDposX && mouseX <= VOIDposX + textWidthz2 && mouseY >= VOIDposY && mouseY <= VOIDposY + 10) {
               this.dragging2 = true;
               this.lastMouseX = mouseX;
               this.lastMouseY = mouseY;
            }
         }
      }

      if (mouseButton == 1) {
         fpsText = "FPS: " + Minecraft.getDebugFPS();
         textWidth = this.fontRendererObj.getStringWidth(fpsText);
         voids = "§e§lSession Voids: §f" + nimuclient.voids;
         textWidthz2 = this.fontRendererObj.getStringWidth(voids);
         if (mouseX >= FPSposX && mouseX <= FPSposX + textWidth && mouseY >= FPSposY && mouseY <= FPSposY + 10) {
            fpsB = !fpsB;
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§8[§bN§8] §7FPS display background: " + (fpsB ? "§aEnabled" : "§cDisabled")));
         }

         if (mouseX >= VOIDposX && mouseX <= VOIDposX + textWidthz2 && mouseY >= VOIDposY && mouseY <= VOIDposY + 10) {
            VOIDB = !VOIDB;
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§8[§bN§8] §7Void display background: " + (VOIDB ? "§aEnabled" : "§cDisabled")));
         }
      }

      super.mouseClicked(mouseX, mouseY, mouseButton);
   }

   private boolean isMouseOver(int mouseX, int mouseY) {
      return mouseX >= this.buttonX && mouseX <= this.buttonX + this.buttonWidth && mouseY >= this.buttonY && mouseY <= this.buttonY + this.buttonHeight;
   }

   private boolean isMouseOver2(int mouseX, int mouseY) {
      return mouseX >= this.buttonX2 && mouseX <= this.buttonX2 + this.buttonWidth2 && mouseY >= this.buttonY2 && mouseY <= this.buttonY2 + this.buttonHeight2;
   }

   protected void mouseReleased(int mouseX, int mouseY, int state) {
      if (state == 0) {
         this.dragging = false;
         this.dragging2 = false;
      }

   }

   public boolean doesGuiPauseGame() {
      return false;
   }
}

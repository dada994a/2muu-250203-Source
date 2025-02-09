package ezl.mtnky.nimu.fig;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ChatComponentText;

public class ModConfigGUI extends GuiScreen {
   private GuiScreen parentScreen;
   private GuiButton toggleButton0;
   private GuiButton toggleButton;
   private GuiButton toggleButton2;
   private GuiButton toggleButton3;
   private GuiButton toggleButton4;
   private GuiButton toggleButton5;
   private GuiButton toggleButton6;
   private GuiTextField textField;

   public ModConfigGUI(GuiScreen parentScreen) {
      this.parentScreen = parentScreen;
   }

   public void initGui() {
      this.buttonList.clear();
      this.toggleButton0 = new GuiButton(6, this.width / 2 - 100, this.height / 2 - 170, 200, 20, this.getToggleText0());
      this.buttonList.add(this.toggleButton0);
      this.toggleButton = new GuiButton(0, this.width / 2 - 100, this.height / 2 - 140, 200, 20, this.getToggleText1());
      this.buttonList.add(this.toggleButton);
      this.toggleButton2 = new GuiButton(1, this.width / 2 - 100, this.height / 2 - 110, 200, 20, this.getToggleText2());
      this.buttonList.add(this.toggleButton2);
      this.toggleButton3 = new GuiButton(2, this.width / 2 - 100, this.height / 2 - 50, 200, 20, this.getToggleText3());
      this.buttonList.add(this.toggleButton3);
      this.toggleButton4 = new GuiButton(3, this.width / 2 - 100, this.height / 2 - 20, 200, 20, this.getToggleText4());
      this.buttonList.add(this.toggleButton4);
      this.toggleButton5 = new GuiButton(4, this.width / 2 - 100, this.height / 2 + 10, 200, 20, this.getToggleText5());
      this.buttonList.add(this.toggleButton5);
      this.toggleButton6 = new GuiButton(5, this.width / 2 - 100, this.height / 2 + 40, 200, 20, this.getToggleText6());
      this.buttonList.add(this.toggleButton6);
      this.buttonList.add(new GuiButton(100, this.width / 2 - 100, this.height / 2 + 70, 200, 20, I18n.format("gui.done", new Object[0])));
   }

   private String getToggleText0() {
      return ModConfig.sprint ? "§7Sprint: §a§lON" : "§7Sprint: §c§lOFF";
   }

   private String getToggleText1() {
      return ModConfig.aflag ? "§7Auto Flag Collect: §a§lON" : "§7Auto Flag Collect: §c§lOFF";
   }

   private String getToggleText2() {
      return ModConfig.avoid ? "§7Auto Void: §a§lON" : "§7Auto Void: §c§lOFF";
   }

   private String getToggleText3() {
      return ModConfig.avoidchrma ? "§7Auto Void Chroma(虹色): §a§lON" : "§7Auto Void Chroma(虹色): §c§lOFF";
   }

   private String getToggleText4() {
      return ModConfig.avoidmode ? "§7Auto Void Mode表示: §a§lON" : "§7AutoVoid Mode表示: §c§lOFF";
   }

   private String getToggleText5() {
      return ModConfig.aflagchrma ? "§7Auto Flag Collect Chroma(虹色): §a§lON" : "§7Auto Flag Collect Chroma(虹色): §c§lOFF";
   }

   private String getToggleText6() {
      return ModConfig.aflagmode ? "§7Auto Flag Collect Mode表示: §a§lON" : "§7Auto Flag Collect Mode表示: §c§lOFF";
   }

   protected void actionPerformed(GuiButton button) {
      if (button.id == 0) {
         ModConfig.aflag = !ModConfig.aflag;
         this.toggleButton.displayString = this.getToggleText1();
      } else if (button.id == 1) {
         if (Minecraft.getMinecraft().thePlayer != null) {
            if (!Minecraft.getMinecraft().thePlayer.getUniqueID().equals("e36c62608c2149a8a487811ad9ce854b")) {
               Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§7[§bN§7] §f§l!!!だめですよ!!!"));
            } else {
               ModConfig.avoid = !ModConfig.avoid;
               this.toggleButton2.displayString = this.getToggleText2();
            }
         }
      } else if (button.id == 2) {
         ModConfig.avoidchrma = !ModConfig.avoidchrma;
         this.toggleButton3.displayString = this.getToggleText3();
      } else if (button.id == 3) {
         ModConfig.avoidmode = !ModConfig.avoidmode;
         this.toggleButton4.displayString = this.getToggleText4();
      } else if (button.id == 4) {
         ModConfig.aflagchrma = !ModConfig.aflagchrma;
         this.toggleButton5.displayString = this.getToggleText5();
      } else if (button.id == 5) {
         ModConfig.aflagmode = !ModConfig.aflagmode;
         this.toggleButton6.displayString = this.getToggleText6();
      } else if (button.id == 6) {
         ModConfig.sprint = !ModConfig.sprint;
         this.toggleButton0.displayString = this.getToggleText0();
      } else if (button.id == 100) {
         this.mc.displayGuiScreen(this.parentScreen);
      }

   }

   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
      drawRect(0, 0, this.width, this.height, (new Color(0, 0, 0, 100)).getRGB());
      this.drawCenteredString(this.fontRendererObj, "§b§lにむくらいあんと", this.width / 2, 40, 16777215);
      super.drawScreen(mouseX, mouseY, partialTicks);
   }
}

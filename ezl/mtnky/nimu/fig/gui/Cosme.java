package ezl.mtnky.nimu.fig.gui;

import java.awt.Color;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;

public class Cosme extends GuiScreen {
   private GuiScreen parentScreen;
   private GuiButton toggleButton0;
   private GuiButton toggleButton;
   private GuiButton toggleButton2;
   private GuiButton toggleButton3;
   private GuiButton toggleButton4;
   private GuiButton toggleButton5;
   private GuiButton toggleButton6;
   private GuiTextField textField;

   public Cosme(GuiScreen parentScreen) {
      this.parentScreen = parentScreen;
   }

   public void initGui() {
      this.buttonList.clear();
      this.buttonList.add(new GuiButton(100, this.width / 2 - 100, this.height / 2 + 70, 200, 20, I18n.format("gui.done", new Object[0])));
   }

   protected void actionPerformed(GuiButton button) {
      if (button.id == 100) {
         this.mc.displayGuiScreen(this.parentScreen);
      }

   }

   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
      drawRect(0, 0, this.width, this.height, (new Color(0, 0, 0, 100)).getRGB());
      this.drawCenteredString(this.fontRendererObj, "§b§lにむくらいあんと", this.width / 2, 30, 16777215);
      this.drawCenteredString(this.fontRendererObj, "§e§lCosmetics", this.width / 2, 40, 16777215);
      this.drawCenteredString(this.fontRendererObj, "§cYou don't have any cosmetics...", this.width / 2, 0, 0);
      super.drawScreen(mouseX, mouseY, partialTicks);
   }
}

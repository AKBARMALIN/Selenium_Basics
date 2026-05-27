package com.akbar._01_basics;

public class _05_Xpath_Axes {
    public static void main(String[] args) {


        // XPath axes allow you to navigate the DOM tree relative to a known element. Common axes include:

        // - parent: Selects the parent of the current node.
        //Eg: //input[@id='txtUsername']/parent::form

        // - child: Selects the children of the current node.
        // Eg: //div[@id='divUsername']/child::input
        // Note: In practice / is used instead of child:: from the known Xpath.

        // - ancestor: Selects all ancestors (parent, grandparent, etc.) of the current node.
        // Eg //input[@name='txtUsername']/ancestor::form

        // - descendant: Selects all descendants (children, grandchildren, etc.) of the current node.
        // Eg: //form[@id='frmLogin']/descendant::input

        // - following: Selects everything in the document after the closing tag of the current node.
        // Eg: //input[@id='txtUsername']/following::input

        // - preceding: Selects everything in the document before the opening tag of the current node.
        // Eg: //span[text()='Password']/preceding::input

        // - following-sibling: Selects all siblings after the current node.
        // Eg: //input[@id='txtUsername']/following-sibling::span

        // - preceding-sibling: Selects all siblings before the current node.
        // Eg: //span[contains(text(), 'Username')]/preceding-sibling::input

        //span[text()>100]
        //span[text()<100]
        //span[text()>=100]
        //span[text()<=100]
        //span[text()!=100]

    }
}

package lib;

/**
 * Hussein's BTQueue
 * Author: Hussein Suleman
 * Edited: Awonke Mnotoza
 * Date: 26 March 2017
 */
public class BTQueue
{   
   BTQueueNode head;
   BTQueueNode tail;
      
   /** 
    * Constructor
    */
   public BTQueue ()
   {
      head = null;
      tail = null;
   }
   
   /** 
    * Get the next node
    * @return BinaryTreeNode
    */
   public BinaryTreeNode getNext ()
   {
      if (head == null)
         return null;
      BTQueueNode qnode = head;
      head = head.next;
      if ( head == null )
         tail = null;
      return qnode.node;
   }
   
   /** 
    * Enqueue node
    * @param node the node to enqueue
    */
   public void enQueue ( BinaryTreeNode node )
   {
      if (tail == null)
      {   
         tail = new BTQueueNode (node, null);
         head = tail;
      }   
      else
      {
         tail.next = new BTQueueNode (node, null);
         tail = tail.next;
      }   
   }   
}

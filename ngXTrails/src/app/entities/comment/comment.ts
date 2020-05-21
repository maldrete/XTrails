import { User } from '../user/user';
import { Trail } from '../trail/trail';


export class Comment {
  id: number;
  actualComment: string;
  user: User;
  trail: Trail;
  datePosted: Date;

  constructor(
    id?: number,
    actualComment?: string,
    user?: User,
    trail?: Trail,
    datePosted?: Date
  ) {
    this.id = id;
    this.actualComment = actualComment;
    this.user = user;
    this.trail = trail;
    this.datePosted = datePosted;
  }
}
